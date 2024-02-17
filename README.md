# Instructions

### Starting the application

For starting the application, it is neccessary to run the script init_setup.sh in your terminal. 
The script will run the following:

1. It will activate the environment.
- .venv\Scripts\activate
2. It will install the neccessary dependencies.
- pip install -r requirements.txt
3. It will run the application in debug mode, which enables us to reload the browser tab of our application and see the changes, without restarting the application.
- flask --app app run --debug