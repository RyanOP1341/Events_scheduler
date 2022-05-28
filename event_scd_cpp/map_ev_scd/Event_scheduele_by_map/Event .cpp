#include "Event.h"

Event::Event(string name, string place, int sday, int smonth, int syear, int hour, int min, int option, int ehour, int emin) {
	this->eventName = name;
	this->eventPlace = place;
	this->eventStartDateStruct.day = sday;
	this->eventStartDateStruct.month = smonth;
	this->eventStartDateStruct.year = syear;

	this->eventStartTimeStruct.hour = hour;
	this->eventStartTimeStruct.min = min;
	this->seteventReminderTime( option);



	this->end_timeStruct.hour = ehour;
	this->end_timeStruct.min = emin;
	this->done = false;
}

#include"Event.h"
using namespace std;

//constructor
Event::Event() {}


//attributes
void Event::seteventName(string name)
{
	eventName = name;
}
void Event::seteventPlace(string place)
{
	eventPlace = place;
}


void Event::seteventStartDateStruct(int day, int month, int year)
{
	this->eventStartDateStruct.day = day;
	this->eventStartDateStruct.month = month;
	this->eventStartDateStruct.year = year;
}




void Event::seteventStartTimeStruct(int hour, int minutes)
{

	this->eventStartTimeStruct.hour = hour;
	this->eventStartTimeStruct.min = minutes;

}
void Event::set_end_timeStruct(int hour, int minutes) {

	this->end_timeStruct.hour = hour;
	this->end_timeStruct.min = minutes;

}

void Event::seteventReminderTime(int option)
{
	// the actual event time 
	int startHour = this->geteventStartTimeStruct().hour ;
	int startMin = this->geteventStartTimeStruct().min;

	//how late is the reminder in hours and minutes
	int remMin = option %60;
    int remHour = (option - remMin) / 60;
 
	//calculate reminder time at hh:mm format
	int Mins = startMin -remMin;
    int Hours = startHour - remHour;
	while (Mins < 0){ 
		Mins = 60 + Mins;
		Hours -=1;
	}

	
	while (Hours < 0) Hours = 24 + Hours;
	
	 Mins = Mins %60;
     Hours = Hours %24;
	
	
	this->seteventReminderTimeStruct(Hours, Mins);


}

void Event::seteventReminderTimeStruct(int hour, int min)
{
	this->eventReminderTimeStruct.hour = hour;
	this->eventReminderTimeStruct.min = min;

}







void Event::setdone()
{
	done = true;
}







// getters 
string Event::geteventName()
{
	return eventName;
}
string Event::geteventPlace()
{
	return eventPlace;

}
Date Event::geteventStartDateStruct()
{
	return eventStartDateStruct;

}

Time Event::geteventStartTimeStruct()
{
	return eventStartTimeStruct;

}

Time Event::get_end_timeStruct()
{
	return end_timeStruct;
}


Time Event::geteventReminderTimeStruct()
{
	return eventReminderTimeStruct;

}
bool Event::checkDone()
{
	return done;

}



