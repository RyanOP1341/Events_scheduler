#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
#include"Event.h"
#include"User.h"


using namespace std;


//int main()
//{
//	User ali =  User("ali","123");
//	
//	 cout << ali.sign_up() << endl;
//	// cout << yousef.sign_in() << endl;
//
//	// cout << ali.sign_up() << endl;
//	// cout << yousef.sign_up() << endl;
//
//	// cout << mohamed.sign_in() << endl;
//	// cout << mohamed.sign_up() << endl;
//	// cout << mohamed.sign_in() << endl;
//
//
//
//
//
//	// //Event event("metting","office",22,5,2022,5,30,120,7,30);
//	
//	// Event event2("reading","library",17,8,2023,10,30,120,11,30);
//	Event event3("new", "lab5", 21, 7, 2022,      2      ,0, 0, 4, 0);
//	//event3.seteventReminderTime(180);
//	// //Event ev
//	// //ev.seteventName("work_shop");
//	// //ev.seteventPlace("hall4");
//	// //ev.seteventStartDateStruct(18,12,2022);
//	// //ev.seteventStartTimeStruct(10,30);
//	// //ev.set_end_timeStruct(11,30);
//	// //ev.seteventReminderTime(120);
//	// //cout << ev.geteventStartDateStruct().year << "/" << ev.geteventStartDateStruct().month << "/" << ev.geteventStartDateStruct().day << "  " << ev.geteventStartTimeStruct().hour << ":" << ev.geteventStartTimeStruct().min << endl;
//	// //cout << "Ev_key = " << current_user.genrate_key(ev);
//	// // 
//	 ali.add_event(event3);
//	// /current_user.delete_event(20229191030);
//	// ali.update_event(20225181030,"party","house",17,5,2022,15,30,120,17,30);
//	// //cout << current_user.update_event(20229191030, "metting", "office", 19, 9, 2022, 11, 30, 120, 12, 30);
//	// //current_user.delete_event(20229171030);
//	// //current_user.write_events();
//	// current_user.display_events(current_user.sort_by_reminder());
//
//	
//}

int main(int argc, char* argv[])
{

    string args[20];
    for (int i = 0; i < argc; i++)
    {
        args[i] = argv[i];
    }

    User user=User(args[2],args[3]);

    if (args[1] == "/Sign_up") {
        cout << user.sign_up();

    }
    else if (args[1] == "/Sign_in")
    {
        cout << user.sign_in();
    }
    else if (args[1] == "/Add_Event")
    {
        Event event = Event(args[4], args[5], atoi(args[6].c_str()), atoi(args[7].c_str()), atoi(args[8].c_str()), atoi(args[9].c_str()), atoi(args[10].c_str()), atoi(args[11].c_str()), atoi(args[12].c_str()), atoi(args[13].c_str()));
            cout << user.add_event(event);

    }
    else if (args[1] == "/Delete")
    {
        user.delete_event(stoll(args[4]));
    }
    else if (args[1] == "/Update_Event")
    {
        cout << user.update_event(stoll(args[4]), args[5], args[6], atoi(args[7].c_str()), atoi(args[8].c_str()), atoi(args[9].c_str()), atoi(args[10].c_str()), atoi(args[11].c_str()), atoi(args[12].c_str()), atoi(args[13].c_str()), atoi(args[14].c_str()));
    }
    else if (args[1] == "/Display")
    {
        user.display_events(user.get_Events());

    }
    else if (args[1] == "/sort_reminder")
    {
        user.display_events(user.sort_by_reminder());
    }
    else if (args[1] == "/Display_done")
    {
        //user.write_done_events();
        user.display_done_events();
    }
    else if (args[1] == "/Clear_history")
    {

        user.clear_history();
    }




}