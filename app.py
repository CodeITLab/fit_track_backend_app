from flask import Flask
from src.controllers.user import user

app = Flask(__name__)
app.register_blueprint(user)