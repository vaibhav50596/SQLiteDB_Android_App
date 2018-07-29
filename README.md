# SQLiteDB_Android_App

This Android app has SignUp and SignIn functionality by using SQLite database. App has 2 EditText views. you enter email and password.
Hit SignUp button and then Use same credentials for SignIn. 
If credentials are wrong then you will get Toast message that "Wrong Email or Password".

We should create one java class(in my project it is, "DatabaseHelper") which will extend SQLiteOpenHelper in order to use SQLite database.

I have used ContentValues to insert email and password data in database table. ==> While SignUp
I have used Cursor to retrieve data from database table. ==> While SignIn

How to access SQLite database to see whether entered data is stored or not?

  1.Run application on AVD (Emulator) and SignUp by entering email and password.
  
  2.View -> Tool Windows -> Device File Explorer -> data -> data-> find your package name of app -> databases -> inside this you will find
    database file.(UserData.db)
    
  3.Right click on it and save it.\
  
  4.Now open this file with SQLite Browser. (To download SQLite browser, http://sqlitebrowser.org/ <= click here)
  
  5.Finally click on "Open Database" in SQLite Browser and open the saved file.
  
  6.You will see Table created and entered data while signing up.
