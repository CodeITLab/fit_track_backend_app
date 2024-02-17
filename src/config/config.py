import os
from flask_sqlalchemy import SQLAlchemy
from flask_marshmallow import Marshmallow

# Grabs the folder where the script runs.
# In my case: D:\9. Code IT Lab\fit_track_backend_app\src\config\config.py
basedir = os.path.abspath(os.path.dirname(__file__))

db = SQLAlchemy()
ma = Marshmallow()

# Enable debug mode, that will refresh the page when you make changes.
DEBUG = True

# Connect to the MYSQL database
SQLALCHEMY_DATABASE_URI = "sqlite:///" + os.path.join(basedir, 'database.db')

# Turn off the Flask-SQLAlchemy event system and warning
SQLALCHEMY_TRACK_MODIFICATIONS = False