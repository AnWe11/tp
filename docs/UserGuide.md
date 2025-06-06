---
layout: page
title: User Guide
---

## About FitFlow

Managing clients as a personal trainer is never easy. Beyond conducting workouts, trainers must juggle scheduling, track client progress, consider individual goals and medical histories, and ensure each client gets a personalized experience. While popular client management apps like Trainerize, TrueCoach, and My PT Hub offer various features, they come with subscription costs, steep learning curves, and cluttered interfaces. Additionally, these platforms lack built-in conflict detection, forcing trainers to manually track overlapping client schedules.

Introducing FitFlow — **a free desktop app designed specifically for personal trainers in Singapore to streamline client management. It is optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).** It provides trainers with a fast and reliable way to store, retrieve, and update client details, including fitness goals, session history, and health information.

What sets FitFlow apart is its intelligent conflict detection system. The app automatically flags scheduling overlaps, helping trainers avoid double bookings and maintain a seamless flow of appointments.

By streamlining administrative tasks, FitFlow lets trainers focus on what matters most—empowering their clients on their fitness journeys.
<div style="page-break-after: always;"></div>

## Using this Guide

The purpose of this user guide is to **help you install FitFlow**, as well as be a **resource you can refer to** if you require any additional help.

You can use the [Table of contents](#table-of-contents) to navigate directly to what you're looking for.

<div markdown="block" class="alert alert-info">:bulb: **Tips/Info:**<br>
These boxes contain important/useful information or tips that can help you with using FitFlow.
</div>

<div markdown="block" class="alert alert-warning">:exclamation: **Note:**<br>
These boxes indicate information that you should take note of to avoid running into problems.
</div>

<div markdown="block" class="alert alert-danger">:rotating_light: **Caution:**<br>
These boxes indicate warnings about potential negative outcomes.
</div>
<div style="page-break-after: always;"></div>

## Table of Contents

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

2. Download the latest `.jar` file from [here](https://github.com/AY2425S2-CS2103T-T13-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your FitFlow app.

4. Go to your home folder and double-click on the `.jar` file to launch the application.<br>
    * If the above does not work, try the below steps:
        1. Open a command terminal for your operating system.
            * Windows: Press Windows button + X on the keyboard. Click on Terminal.
            * macOS: Press Command (⌘) + Space on the keyboard and search for "Terminal". Open the Terminal application.
            * Linux: Press Ctrl + Alt + T. The terminal application should open.
        2. Change the directory you are currently in to the home folder, using the command `cd`.
            * A simple way to find the directory is to go to the home folder your normal file browsing app and copying the directory at the address bar. For example, the command could be `cd ~/Downloads/FitFlowFolder`.
            * Another simple way to navigate to the directory is to go to the home folder and right-click on an empty space, then select the option "Open in terminal" to immediately open a terminal in that directory.
        3. Use the `java -jar FitFlow.jar` command to run the application.

    A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
    ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will display the list of available commands in FitFlow.<br>
   Some example commands you can try:

   * `add n/John Doe p/81234567` : Adds a client named `John Doe` to FitFlow.

   * `add n/Alice Pauline p/94351253 rs/Mon 1400 1600 ots/1/2 1000 1200 g/Get fitter mh/Twisted right ankle l/Bishan ActiveSG Gym t/friends` : Adds a client named `Alice Pauline` with many details such as her schedule, fitness goal, medical history and location.

   * `find John Doe` : Finds clients whose names match 'John' or 'Doe' and shows their name and phone number in the Client List. The Output Box will show the number of clients found by the application.

   * `view monday` : Displays the schedules the personal trainer has with the clients on that day.

   * `view 17/2/25` : Displays the schedules the personal trainer has with the clients on that day.

   * `edit 1 p/81234567 rs/Tue 1600 1800 g/Do 10 pull ups` : Edits the details of the 1st client shown in the current list.

   * `delete 3` : Deletes the 3rd client shown in the current list.

   * `help` : Displays the list of available commands the user can use in FitFlow.

   * `help /add` : Displays the format for the specific command in FitFlow.

   * `list` : Lists all clients.

   * `clear` : Deletes all clients.

   * `exit` : Exits FitFlow app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Guided Tutorial

To get a feel for the app before actually starting to use it, check out our [_Guided Tutorial_](GuidedTutorial.md).

--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Tips about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `list 123`, it will be interpreted as `list`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>


### Help : `help`

Displays the description and formatting of commands in FitFlow.

Format: `help [/COMMAND_NAME]`

* Display all the available commands in FitFlow.
* Displays a specific command and will give the specific description and formatting for that command.

Examples:
* `help` will display the description of all the available commands in FitFlow.
* `help /add` will display the command description and formatting for the add command in FitFlow.

Invalid Examples:
* `help add`: **Missing slash before command.** Use `help /add`.

### Adding a client: `add`

Adds a client to FitFlow.

Format: `add n/NAME p/PHONE_NUMBER [rs/RECURRING_SCHEDULE]…​ [ots/ONE_TIME_SCHEDULE]…​ [g/GOALS] [mh/MEDICAL_HISTORY] [l/LOCATION] [t/TAG]…​`

<div markdown="span" class="alert alert-info">:bulb: **Tip:**<br>
- A client can have any number of recurring schedule, one time schedule, or tags (including 0).<br>
</div>

<div markdown="block" class="alert alert-warning">:exclamation: **Note:**<br>
- A client should have at least have a name and a phone number to be added.<br>
- A client is uniquely identified by their name. Thus, you cannot add two clients with the exact same name, regardless of case (i.e. john doe cannot be added with John Doe already in the client list).<br>
The reason for this is so that you will not be confused on which client is which when trying to look for their details. You must differentiate them in some way before adding.
- Any date provided that excludes year will be treated as a date in the current year.<br>
- A client with a recurring schedule or one time schedule that conflicts internally or with other clients' schedules will still be added.<br>
- Use the edit command to rectify any conflicting schedules.
</div>

* For `NAME`, `GOALS`, `MEDICAL_HISTORY`, `LOCATION`, and `TAG`, these fields accept all ASCII characters.
* For `PHONE_NUMBER`, any 8-digit number starting with 6, 8, or 9 is accepted.
* For `RECURRING SCHEDULE`, use the format `DAY START_TIME END_TIME`.
  * `DAY` can be any day of the week i.e. `Monday`. You can use 3-letter short-form days as well i.e. `Mon`.
  * `START_TIME` and `END_TIME` should be 4 digits, in 24-hour format.
* For `ONE_TIME_SCHEDULE`, use the format `DATE START_TIME END_TIME`.
  * `DATE` should be in the format `[D]D/[M]M[/YY]`.
    * The day and month of the date can have its leading `0` omitted if it is single digit.
    * The year of the date can be omitted. In this case, the application will assume the current year.
  * `START_TIME` and `END_TIME` should be 4 digits, in 24-hour format.
* To rectify a client's conflicting schedules, refer to the [**`edit`**](#editing-a-client--edit) section.

Examples:
* This command adds a client who is your _friend_ named _Alice Pauline_ who has the phone number _94351253_. She has weekly sessions on _Monday_ from _1400_ to _1600_, and a standalone appointment on _1st February this year_. She wants to _get fitter_ after she _twisted her right ankle_. You will be having training with her at the _Bishan ActiveSG Gym_.<br>
`add n/Alice Pauline p/94351253 rs/Mon 1400 1600 ots/1/2 1000 1200 g/Get fitter mh/Twisted right ankle l/Bishan ActiveSG Gym t/friends`
  ![Result for 'add Alice Pauline'](images/addAlicePauline.png)
* `add n/Betsy Crowe t/friend g/Lose weight l/Jurong GymBox p/91234567 mh/Lower back injury rs/Wed 1500 1700 rs/Fri 1200 1330`

Invalid Examples:
* `add n/John`: **Missing required field** `p/PHONE_NUMBER`.
* `add p/81234567`: **Missing required field** `n/NAME`.
* `add n/John Doe p/12345678`: **Invalid phone number:** must be 8 digits and start with 6, 8, or 9.
* `add n/John Doe p/81234567 rs/Monday 9am 11am`: **Invalid time format:** must be 4-digit 24-hour format like `0900`.
* `add n/John Doe p/81234567 rs/Mon 1600`: **Missing end time in recurring schedule.**
* `add n/John Doe p/81234567 ots/30/2 1000 1200`: **Invalid date:** 30th February does not exist.

### Listing all clients: `list`

Always shows a list of all the clients in FitFlow, regardless of any previous commands that might have filtered the list.

Format: `list`

Examples:
* `list` displays and indexes all the clients in FitFlow.
* If the list has been filtered because of the `find` command, you can use the `list` command to display the full list of clients again.

### Locating clients by name: `find`

Find clients whose names contain any of the given keywords, showing them in the Client List on the left.<br>
You can then use [**`display`**](#displaying-a-clients-details-display) to display the details of the client you want.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g. `hans` will match `Hans`.
* The order of the keywords does not matter. i.e. `Hans Bo` will match `Bo Hans`.
* You do not need to include the name tag in the keyword, e.g. if you want to search for the name 'Alex' it should be `find Alex` and not `find n/Alex`.
* Only the name is searched.
* Only the name and contact number of the client will be displayed. To see a client's full details, refer to the [**`display`**](#displaying-a-clients-details-display) section.
* Only full words will be matched i.e. `Han` will not match `Hans`.
* Clients matching at least one keyword will be returned (i.e. `OR` search).
  i.e. `Hans Bo` will return `Hans Gruber`, `Bo Yang`.

Examples:
* `find John` returns `john` and `John Doe`.
* `find alex david` returns `Alex Yeoh`, `David Li`.<br>
  ![Result for 'find alex david'](images/findAlexDavidResult.png)

Invalid Examples:
* `find`: **No keywords provided.**


### Displaying a client's details: `display`

Display a client's full details in the client list, identified by the index number used in the displayed client list.

Format: `display INDEX`

<div markdown="block" class="alert alert-warning">:exclamation: **Note:**<br>
- Can be used in conjunction with 
    - `list` to show a list of all the clients.<br>
    - `find` to filter the clients based on the keyword.<br> 
    - `view` to filter the clients based on day/date of the schedule.<br>
</div>

* Displays the client at the specified `INDEX`.
* The index refers to the index number shown in the displayed client list.
* The index **must be a positive integer** 1, 2, 3, …​.

Examples:
* `display 5` will display the details of the person at index 5.
* `view Mon` followed by `display 1` displays the details of the 1st client in the results of the `find` command.
* `find alex david` followed by `display 1` displays the details of the 1st client in the results of the `find` command.
  ![Result for 'display alex'](images/displayAlexDetails.png)

Invalid Examples:
* `display`: **Missing index.**
* `display zero`: **Index must be a positive integer.**
* `display -1`: **Negative index is invalid.**
* `display 999`: **Index out of bounds, no such client in the displayed list.** (Assumption: There are lesser than 999 clients in the displayed list.)

### Viewing Schedules: `view`

Displays the schedules the personal trainer has with clients on that day or date.

Format: `view DAY/DATE`<br>
DAY Format: `Monday` or `Mon`<br>
DATE Format: `[D]D/[M]M[/YY]`

<div markdown="block" class="alert alert-warning">:exclamation: **Note:**<br>
- Any date provided that excludes year will be treated as a date in the current year.<br>
- Viewing a day (i.e. Mon), will also return `ONE_TIME_SCHEDULE` schedules in the coming Monday.
</div>

* The search is case-insensitive. i.e. `Monday` will match `monday`.
* A day or date field must be provided.
* For `DAY`, 3-letter short-form is allowed, i.e. `Monday` will match with `mon`. Here are a list of accepted `DAY` names:<br>
`Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday`, `Sunday`<br>
`Mon`, `Tue`, `Wed`, `Thu`, `Fri`, `Sat`, `Sun`
* For `DATE`, the format has to be `[D]D/[M]M[/YY]` e.g. `14/2` matches with `14/02/25` and `7/1/25` matches with `07/01/25`.
  * The day and month of the date can have its leading `0` omitted if it is single digit.
  * The year of the date can be omitted. In this case, the application will assume the current year.

Examples:
* `view Tue` returns the list of clients with schedules on Tuesday.
* `view 25/02/25` returns the list of clients with schedules on 25/02/25.
* `view 21/04` returns the list of clients with schedules on 21/04 in today's year of usage.
* `view Monday` returns the list of clients with schedules on Monday.<br>
    ![result for 'view Monday'](images/viewMonday.png)

Invalid Examples:
* `view`: **Missing argument:** must specify a day or date.
* `view Tueday`: **Misspelled day.** Accepted values include `Tuesday` or `Tue`.
* `view 31/4/25`: **Invalid date.** Take note of the number of days in the month being entered.
* `view 14/13/25`: **Invalid month.**

### Editing a client : `edit`

Edits an existing client in FitFlow.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [rs/RECURRING_SCHEDULE]…​ [ots/ONE_TIME_SCHEDULE]…​ [g/GOALS] [mh/MEDICAL_HISTORY] [l/LOCATION] [t/TAG]…​`

<div markdown="block" class="alert alert-warning">:exclamation: **Note:**<br>
- Any date provided that excludes year will be treated as a date in the current year.<br>
- A client with a recurring schedule or one time schedule that conflicts internally or with other clients' schedules will still be added.<br>
- Use the edit command to rectify any conflicting schedules. <br>
- When editing recurring schedules, one time schedules or tags, the **existing parameters** of the client will be **removed** i.e. it is **not cumulative**.
</div>

* Edits the client at the specified `INDEX`.
* The index refers to the index number shown in the displayed client list.
* The index **must be a positive integer** 1, 2, 3, …​.
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* You can remove all the client's recurring schedules, one time schedules and tags by typing `rs/`, `ots/`, and `t/` respectively without specifying any value after it.
* For more details on how each field should be formatted, refer to the [**`add`**](#adding-a-client-add) section.

Examples:
*  `edit 1 p/91234567 l/Anytime Fitness ots/4/4 1200 1400` Edits the phone number, location, and one time schedule of the 1st client to be `91234567`, `Anytime Fitness`, and `4/4 1200 1400` respectively.
   ![Result for 'edit Alice Pauline'](images/editAlicePauline.png)
*  `edit 2 n/Betsy Crower rs/ ots/ t/` Edits the name of the 2nd client to be `Betsy Crower` and clears all existing recurring schedules, one time schedules and tags.

Invalid Examples:
* `edit`: **Missing index.**
* `edit two`: **Index must be a positive integer.**
* `edit 1`: **No fields provided to update.**
* `edit 1 p/1234`: **Invalid phone number.**
* `edit 1 rs/Mon 1000`: **Incomplete recurring schedule (missing end time).**

### Deleting a client : `delete`

Deletes the specified client from FitFlow.

Format: `delete INDEX`

<div markdown="block" class="alert alert-danger">:rotating_light: **Caution:**<br>
**This command is irreversible. Use with caution.**
</div>

* Deletes the client at the specified `INDEX`.
* The index refers to the index number shown in the displayed client list.
* The index **must be a positive integer** 1, 2, 3, …​.

Examples:
* `list` followed by `delete 2` deletes the 2nd client from FitFlow.
* `find Betsy` followed by `delete 1` deletes the 1st client in the results of the `find` command.

Invalid Examples:
* `delete`: **Missing index.**
* `delete abc`: **Index must be a positive integer.**
* `delete 100`: **Index out of bounds, no such client in current list.** (Assumption: There are lesser than 100 clients in the displayed list.)

### Exiting the program : `exit`

Exits the program.

Format: `exit`


### Clearing all entries : `clear`

Clears all entries from FitFlow.

Format: `clear`

<div markdown="block" class="alert alert-danger">:rotating_light: **Caution:**<br>
**This command is irreversible. Use with caution.**
</div>


### Saving the data

FitFlow data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


### Editing the data file

FitFlow data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.


--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the sample data file it creates with the file that contains the data of your previous FitFlow home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.
3. The [**view**](#viewing-schedules-view) command currently does not highlight conflicting schedules when used. This is known and will be rectified in a future to make it easier for client's to rectify conflicting schedules. It is not prioritised as a user is still able to manually see and rectify conflicting schedules.
4. The dates are only accepted if the year is in a 2-digit format, not in a 4-digit format. This is known and will be updated in a future update. It is not prioritised as it is unlikely that a user will save a schedule in a year earlier than 2000 and after 2100 for now.
5. When editing recurring schedules, one time schedules or tags, the existing parameters of the client will be removed i.e. it is not cumulative. This is a known limitation and the behaviour will be adjusted in an update. It is not prioritised as the user can still add the fields manually.
6. When adding or editing either one time schedules or recurring schedules, the given date/day and time may not be parsed due to additional whitespace characters between the date/day and time. (i.e. an `edit` command with the prefix and parameter `rs/Monday   1400 1600` or `rs/Monday 1400   1600`will display an error). This is a known limitation for `add` and `edit` commands when adding/editing clients with the `ots/` prefix and/or `rs/` prefix. The remedy is to remove the additional whitespaces and ensure that there is only 1 whitespace separating the date/day and times.
7. Past one-time schedules that fall on the same day as a recurring schedule are reported as schedule conflicts. This is a known issue and will be addressed in a future update. It is not prioritised as it does not hinder the user’s ability to plan effectively—only future scheduling is typically relevant, and users can still interpret the conflict warnings accordingly.
8. **If you open FitFlow and find the clients list to be unexpectedly empty despite having some saved clients prior to opening**, the file storing the clients' data is likely corrupted. This file can still be found at `data/addressbook.json` from the directory FitFlow is located at. Inputting any command after discovering this issue will cause all remaining data in the `addressbook.json` file to be removed. The remedy is to assess the corrupted file's contents and fill up any missing fields.
9. Our application only accepts Singaporean numbers which are 8 digits long and start with a 6, 8 or 9. It does not accept numbers that are more than 8 digits long or start with any other number besides 6, 8 or 9.

--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

## Command summary

Action | Format, Examples
--------|------------------
**Help** | `help [/add] [/list] [/edit] [/find] [/display] [/view] [/delete] [/clear] [/exit]` <br> e.g. `help /add`
**Add** | `add n/NAME p/PHONE_NUMBER [rs/RECURRING_SCHEDULE]…​ [ots/ONE_TIME_SCHEDULE]…​ [g/GOALS] [mh/MEDICAL_HISTORY] [l/LOCATION] [t/TAG]…​` <br> e.g. `add n/Alice Pauline p/94351253 rs/Mon 1400 1600 ots/1/2 1000 1200 g/Get fitter mh/Twisted right ankle l/Bishan ActiveSG Gym t/friends`
**List** | `list` <br> e.g. `list`
**Find** | `find KEYWORD [MORE_KEYWORDS]` <br> e.g. `find John`
**Display** | `display INDEX`<br> e.g. `display 2`
**View** | `view DAY/DATE` <br> e.g. `view Monday`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [rs/RECURRING_SCHEDULE]…​ [ots/ONE_TIME_SCHEDULE]…​ [g/GOALS] [mh/MEDICAL_HISTORY] [l/LOCATION] [t/TAG]…​`<br> e.g. `edit 1 p/91234567 l/Anytime Fitness ots/4/4 1200 1400`
**Delete** | `delete INDEX`<br> e.g. `delete 3`
**Exit** | `exit`
**Clear** | `clear`


