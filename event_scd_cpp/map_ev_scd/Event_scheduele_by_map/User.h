#pragma once
#include<vector>
#include<iostream>
#include<string>  
#include<map>
#include"Event.h"
#include<ctime>
#include<stack>
#include<vector>
#include<fstream>
#include <sstream>
#include<math.h>
#include<cstdlib>
#include<unordered_map>

using namespace std;
class User
{
	string username;
	string password;
	map<long long, Event>Events;
	vector<Event>doneEvents;
public:
	User();
	User(string name, string pass);
	~User();
	void read_Events();
	void write_events();
	void read_done_Events();
	void write_done_events();
	long long genrate_key(Event e);
	bool intersects(Event e);
	int add_event(Event e);
	void delete_event(long long key);
	Time get_current_time();
	Date get_current_Date();
	bool inThePast(Event e);
	int update_event(long long old_key,string name,string place,int day,int month,int year,int shour,int smin,int option,int ehour,int emin);
	void display_events(map<long long,Event>);
	void display_done_events();
	void clear_history();
	map<long long, Event>sort_by_reminder();
	void done_event();
	bool checkDone(Event event);

	//getters
	map<long long, Event>get_Events();
	string get_username();
	string get_password();

	//setters
	void set_username(string name);
	void set_password(string pass);

	//authentication 
		
	bool sign_up();
	bool sign_in();

};

void addUser(string name , string pass);

unordered_map<string , User > readUserData();