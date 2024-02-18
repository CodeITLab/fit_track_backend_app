echo "[ `date` ]": "create venv"
py -m venv .venv
echo "[ `date` ]": "activate venv"
.venv/Scripts/activate
echo "[ `date` ]": "installing the requirements" 
pip install -r requirements.txt
echo "[ `date` ]": "Run the application" 
flask --app app run --debug