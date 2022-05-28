#include "User.h"

User::User()
{
 
}

User::User(string name, string pass)
{
	this->username = name;
	this->password = pass;
	 read_Events();
	 done_event();
	 read_done_Events();
}

User::~User()
{
	write_events();
	write_done_events();
}

void User::read_Events()
{
	string fname ="users_data\\"+ username + ".csv";


	vector<vector<string>> content;
	vector<string> row;
	string line, word;

	fstream file(fname, ios::in);
	if (file.is_open())
	{
		while (getline(file, line))
		{
			row.clear();

			stringstream str(line);

			while (getline(str, word, ','))
				row.push_back(word);
			content.push_back(row);
		}
	}
	else
		cout << "Could not open the file\n";
	for (int i = 0; i < content.size(); i++)
	{
		Event e;
		e.seteventName(content[i][0]);
		e.seteventPlace(content[i][1]);
		e.seteventStartDateStruct(atoi(content[i][2].c_str()), atoi(content[i][3].c_str()), atoi(content[i][4].c_str()));
		e.seteventStartTimeStruct(atoi(content[i][5].c_str()), atoi(content[i][6].c_str()));
		e.set_end_timeStruct(atoi(content[i][7].c_str()), atoi(content[i][8].c_str()));
		e.seteventReminderTimeStruct(atoi(content[i][9].c_str()), atoi(content[i][10].c_str()));
		long long key= genrate_key(e);
		this->Events[key] = e;
        

	}
	file.close();

}

void User::write_events()
{
	ofstream writer;
	string file_name = "users_data\\" + this->username + ".csv";
	writer.open(file_name, ios::out);
	map<int, Event>::iterator it;
	if (!Events.empty())
	{
		for (auto it = this->Events.begin(); it != this->Events.end(); it++)
		{
			writer << it->second.geteventName() << ","
				<< it->second.geteventPlace() << ","
				<< it->second.geteventStartDateStruct().day << ","
				<< it->second.geteventStartDateStruct().month << ","
				<< it->second.geteventStartDateStruct().year << ","
				<< it->second.geteventStartTimeStruct().hour << ","
				<< it->second.geteventStartTimeStruct().min << ","
				<< it->second.get_end_timeStruct().hour << ","
				<< it->second.get_end_timeStruct().min << ","
				<< it->second.geteventReminderTimeStruct().hour << ","
				<< it->second.geteventReminderTimeStruct().min << endl;

		}
	}
	writer.close();



}

void User::read_done_Events()
{
	string fname = "users_data\\" + username + "_done.csv";


	vector<vector<string>> content;
	vector<string> row;
	string line, word;

	fstream file(fname, ios::in);
	if (file.is_open())
	{
		while (getline(file, line))
		{
			row.clear();

			stringstream str(line);

			while (getline(str, word, ','))
				row.push_back(word);
			content.push_back(row);
		}
	}
	else
		cout << "Could not open the file\n";
	for (int i = 0; i < content.size(); i++)
	{
		Event e;
		e.seteventName(content[i][0]);
		e.seteventPlace(content[i][1]);
		e.seteventStartDateStruct(atoi(content[i][2].c_str()), atoi(content[i][3].c_str()), atoi(content[i][4].c_str()));
		e.seteventStartTimeStruct(atoi(content[i][5].c_str()), atoi(content[i][6].c_str()));
		e.set_end_timeStruct(atoi(content[i][7].c_str()), atoi(content[i][8].c_str()));
		e.seteventReminderTimeStruct(atoi(content[i][9].c_str()), atoi(content[i][10].c_str()));
		this->doneEvents.push_back(e);


	}
	file.close();

}

void User::write_done_events()
{
	ofstream writer;
	string fname = "users_data\\" + username + "_done.csv";
	writer.open(fname, ios::out);
	for (int i = 0; i < doneEvents.size(); i++)
	{
		Event ev = doneEvents[i];
		writer << ev.geteventName() << ","
			<< ev.geteventPlace() << ","
			<< ev.geteventStartDateStruct().day << ","
			<< ev.geteventStartDateStruct().month << ","
			<< ev.geteventStartDateStruct().year << ","
			<< ev.geteventStartTimeStruct().hour << ","
			<< ev.geteventStartTimeStruct().min << ","
			<< ev.get_end_timeStruct().hour << ","
			<< ev.get_end_timeStruct().min << ","
			<< ev.geteventReminderTimeStruct().hour << ","
			<< ev.geteventReminderTimeStruct().min << endl;



	}
	writer.close();
}

long long User::genrate_key(Event e)
{
	string x = to_string(e.geteventStartDateStruct().year) + to_string(e.geteventStartDateStruct().month) + to_string(e.geteventStartDateStruct().day) + to_string(e.geteventReminderTimeStruct().hour) + to_string(e.geteventReminderTimeStruct().min);
	long long date_num = stoll(x);

	return date_num;





}

bool User::intersects(Event event)
{
	double e1_start_time = (event.geteventStartTimeStruct().hour * 60) + event.geteventStartTimeStruct().min;
	double e1_end_time = (event.get_end_timeStruct().hour * 60) + event.get_end_timeStruct().min;
	bool intersection = false;
	map<int, Event>::iterator it;
	for (auto it = this->Events.begin(); it != this->Events.end(); it++)
	{

		double e2_start_time = (it->second.geteventStartTimeStruct().hour * 60) + it->second.geteventStartTimeStruct().min;
		double e2_end_time = (it->second.get_end_timeStruct().hour * 60) + it->second.get_end_timeStruct().min;
		//cout << e1_start_time << " : " << e1_end_time << " ........ " << e2_start_time << " : " << e2_end_time << endl;
		if ((event.geteventStartDateStruct().year != it->second.geteventStartDateStruct().year) || (event.geteventStartDateStruct().month != it->second.geteventStartDateStruct().month) || (event.geteventStartDateStruct().day != it->second.geteventStartDateStruct().day))
		{
			//cout << "passed" << endl;

			continue;
		}

		if (e1_start_time < e2_end_time && e1_start_time > e2_start_time)
		{
			return true;
		}
		if (e2_start_time < e1_end_time && e2_start_time > e1_start_time)
		{
			return true;
		}
		if (e1_start_time == e2_start_time || e1_end_time == e2_end_time)
		{
			return true;
		}
		

	}
	return false;
}
int User::add_event(Event e)
{
	long long  key = genrate_key(e);
	float e_s_time = e.geteventStartTimeStruct().hour + e.geteventStartTimeStruct().min / 60;
	float e_e_time = e.get_end_timeStruct().hour + e.get_end_timeStruct().min / 60;
	if (e_s_time>e_e_time)
	{
		//end time must be graterthan start time
		return 4;
	}

	auto it = Events.find(key);
	if (it!=Events.end())
	{
		//event already exists
		return 1;
	}
	if (inThePast(e))
	{
		//event is in the past
		return 2;
	}
	if (intersects(e))
	{
		//intresects
		return 3;
	}
	Events[key] = e;

	return 0;


}

void User::delete_event(long long key)
{
	auto it = Events.find(key);
	if (it!=Events.end())
	{
		this->Events.erase(key);
		
		
	}

	
}

Time User::get_current_time()
{
	//stroring current time in time struct
	Time current_time;
	time_t total_seconds = time(0);
	struct tm* ct = localtime(&total_seconds);
	current_time.min = ct->tm_min;
	current_time.hour = ct->tm_hour;
	return current_time;
}

Date User::get_current_Date()
{
	Date current_date;
	time_t total_seconds = time(0);
	struct tm* ct = localtime(&total_seconds);
	current_date.year = ct->tm_year + 1900;
	current_date.month = ct->tm_mon + 1;
	current_date.day = ct->tm_mday;


	return current_date;
}

bool User::inThePast(Event event)
{
	Time currentTime = get_current_time();
	Date currentDate = get_current_Date();

	float dueTime = (event.geteventStartTimeStruct().hour * 60) + event.geteventStartTimeStruct().min ;
	float currentT = (currentTime.hour * 60)+ currentTime.min ;
	if (currentDate.year > event.geteventStartDateStruct().year)
	{

		return  true;
	}

	if (currentDate.year == event.geteventStartDateStruct().year && currentDate.month > event.geteventStartDateStruct().month)
	{

		return true;
	}
	if (currentDate.year == event.geteventStartDateStruct().year && currentDate.month == event.geteventStartDateStruct().month && currentDate.day > event.geteventStartDateStruct().day)
	{

		return true;
	}
	if (currentDate.year == event.geteventStartDateStruct().year && currentDate.month == event.geteventStartDateStruct().month && currentDate.day == event.geteventStartDateStruct().day && currentT > dueTime)
	{

		return true;
	}
	return false;
}

int User::update_event(long long old_key, string name,string place, int day, int month, int year, int shour, int smin, int option, int ehour, int emin)
{
	Event e;
	e.seteventName(name);
	e.seteventPlace(place);
	e.seteventStartDateStruct(day, month, year);
	e.seteventStartTimeStruct(shour, smin);
	e.set_end_timeStruct(ehour, emin);
	e.seteventReminderTime(option);
	long long key = genrate_key(e);



	auto it = Events.find(old_key);
	if (it != Events.end())
	{


		Event temp = Events[old_key];
		Events.erase(old_key);
		int add = add_event(e);
		return add;
		if (add_event(e) == 0)
		{
			Events[key] = e;
			//cout<< "event updated" << endl;
			return 0;
		}

		Events[old_key] = temp;
		//cout << "could not update \n";
		return 0;


	}

	return 1;
}

void User::display_events(map<long long, Event>)
{
	for (auto it = this->Events.begin(); it != this->Events.end(); it++)
	{
		cout << it->second.geteventName() << "," << it->second.geteventPlace() << "," << it->second.geteventStartDateStruct().day << "/" << it->second.geteventStartDateStruct().month << "/" << it->second.geteventStartDateStruct().year << "," << it->second.geteventStartTimeStruct().hour << ":" << it->second.geteventStartTimeStruct().min << "," << it->second.get_end_timeStruct().hour << ":" << it->second.get_end_timeStruct().min<<"," << it->second.geteventReminderTimeStruct().hour<<":"<< it->second.geteventReminderTimeStruct().min<<endl;

	}
    
}

void User::display_done_events()
{
	if (!doneEvents.empty())
	{

		for (int i = 0; i < doneEvents.size(); i++)
		{
			Event ev = doneEvents[i];
			cout << ev.geteventName() << ","
				<< ev.geteventPlace() << ","
				<< ev.geteventStartDateStruct().day << "/"
				<< ev.geteventStartDateStruct().month << "/"
				<< ev.geteventStartDateStruct().year << ","
				<< ev.geteventStartTimeStruct().hour << ":"
				<< ev.geteventStartTimeStruct().min << ","
				<< ev.get_end_timeStruct().hour << ":"
				<< ev.get_end_timeStruct().min << ","
				<< ev.geteventReminderTimeStruct().hour << ":"
				<< ev.geteventReminderTimeStruct().min << endl;


		}
	}

}

void User::clear_history()
{

		doneEvents.clear();
	
}

map<long long, Event> User::get_Events()
{
	return this->Events;
}

string User::get_username()
{
	return this->username;
}

string User::get_password()
{
	return this->password;
}

void User::set_username(string name)
{
	this->username = name;
}

void User::set_password(string pass)
{
	this->password = pass;
}

map<long long, Event> User::sort_by_reminder()
{
	map<long long, Event>Rem_sorted_map;
	for (auto it = this->Events.begin(); it != this->Events.end(); it++)
	{
		string x = to_string(it->second.geteventStartDateStruct().year) + to_string(it->second.geteventStartDateStruct().month) + to_string(it->second.geteventStartDateStruct().day) + to_string(it->second.geteventReminderTimeStruct().hour) + to_string(it->second.geteventReminderTimeStruct().min);
		long long date_num = stoll(x);
		Rem_sorted_map[date_num] = it->second;
	}
	return Rem_sorted_map;
}

void User::done_event()
{
	//move an event from upcoming events list to  done event list
	//change done flage status to true
	Date current_date = get_current_Date();
	Time current_time = get_current_time();
	if (!Events.empty())
	{

		for (auto it = this->Events.begin(); it != this->Events.end(); )

		{

			if (checkDone(it->second)) {
				this->doneEvents.push_back(it->second);
				this->Events.erase(it++);
			}
			else {
				++it;
			}
		}

	}
	// write_events();
	// writeDoneEvents();
}

bool User::checkDone(Event event)
{
	Time currentTime = get_current_time();
	Date currentDate = get_current_Date();

	float dueTime = (event.get_end_timeStruct().hour * 60) + event.get_end_timeStruct().min;
	float currentT = (currentTime.hour * 60) + currentTime.min;
	if (currentDate.year > event.geteventStartDateStruct().year)
	{

		return  true;
	}

	if (currentDate.year == event.geteventStartDateStruct().year && currentDate.month > event.geteventStartDateStruct().month)
	{

		return true;
	}
	if (currentDate.year == event.geteventStartDateStruct().year && currentDate.month == event.geteventStartDateStruct().month && currentDate.day > event.geteventStartDateStruct().day)
	{

		return true;
	}
	if (currentDate.year == event.geteventStartDateStruct().year && currentDate.month == event.geteventStartDateStruct().month && currentDate.day == event.geteventStartDateStruct().day && currentT > dueTime)
	{

		return true;
	}
	return false;
}






bool User::sign_up(){
    unordered_map<string , User> Users = readUserData();
	User newUser;


	newUser.set_username(this->username);
	newUser.set_password(this->password);
	if (!Users.empty()){
		if(Users.find(this->username) != Users.end())return false;
	}
	
    
	
	Users.insert(pair<string, User>(this->username,newUser ));
	addUser(this->username , this->password);
	return true ; 

}






bool User::sign_in(){
    unordered_map<string ,User> Users = readUserData();
    if(Users.find(this->username) != Users.end() && this->password == Users[this->username].get_password())return true;

	else return false;
    
}




unordered_map<string , User> readUserData(){
	//read usrers data from users file and store it in users map
	unordered_map<string,User> Users;

	fstream file;
	
	file.open("users_data\\users.csv", ios::in);

	vector<vector<string>> content;
	vector<string> row;
	string line, word;

	while (getline(file, line))
	{
		row.clear();

		stringstream str(line);

		while (getline(str, word, ','))
			row.push_back(word);
		content.push_back(row);
	}
	file.close();
	


	for (int i = 0; i < content.size(); i++)
	{
		User user;
		user.set_username(content[i][0]);
		user.set_password(content[i][1]);
		Users.emplace(pair<string , User>(content[i][0], user));

	}
	
	 
	return Users;
}


void addUser(string name , string pass){
	//write a new user in users file
	fstream writer;
	writer.open("users_data\\users.csv", ios::app);
	writer << name << "," << pass <<endl;
    writer.close();
}

