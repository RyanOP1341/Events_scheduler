#pragma once
#include<string>
#include<vector>
#include<iostream>
#include<cstdio>
#include<algorithm>


using namespace std;


struct Date
{
	int day, month, year;

};
struct Time
{

	int hour, min;
};

class Event
{
private:
	string eventName;
	string eventPlace;
	Date eventStartDateStruct;

	Time eventStartTimeStruct;
	Time end_timeStruct;
	Time eventReminderTimeStruct;

	bool done = false;


public:
	Event();
	Event(string eventName);
	Event(string name, string place, int sday, int smonth, int syear, int hour, int min, int option, int ehour, int emin);

	//setters 
	void seteventName(string s);
	void seteventPlace(string s);
	void seteventStartDateStruct(int day, int month, int year);

	void seteventStartTimeStruct(int hour, int minutes);
	void set_end_timeStruct(int hour, int minutes);
	void seteventReminderTimeStruct(int hour, int minutes);
	void seteventReminderTime( int option);
	void setdone();

	//getters
	string geteventName();
	string geteventPlace();
	Date geteventStartDateStruct();

	Time geteventStartTimeStruct();
	Time get_end_timeStruct();
	Time geteventReminderTimeStruct();
	bool checkDone();

};
