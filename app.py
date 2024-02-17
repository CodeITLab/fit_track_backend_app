from flask import Flask
from src.controllers.getUserData import getUserData
from src.controllers.saveUserData import saveUserData

app = Flask(__name__)
app.register_blueprint(getUserData)
app.register_blueprint(saveUserData)