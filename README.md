# SQLiteDB_Android_App

This Android app has SignUp and SignIn functionality by using SQLite database. App has 2 EditText views. you enter email and password.
Hit SignUp button and then Use same credentials for SignIn. 
If credentials are wrong then you will get Toast message that "Wrong Email or Password".

We should create one java class(in my project it is, "DatabaseHelper") which will extend SQLiteOpenHelper in order to use SQLite database.

I have used ContentValues to insert email and password data in database table. ==> While SignUp
I have used Cursor to retrieve data from database table. ==> While SignIn