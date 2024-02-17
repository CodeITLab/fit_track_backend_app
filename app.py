from flask import Flask

from src.controllers.getUserData import getUserData
from src.controllers.saveUserData import saveUserData
from src.models.user import db

def create_app():
    app = Flask(__name__)  # flask app object
    app.config.from_object('src.config.config')  # Configuring from Python Files

    db.init_app(app)  # Initializing the database
    return app

app = create_app()  # Creating the app

app.register_blueprint(getUserData)
app.register_blueprint(saveUserData)

if __name__ == '__main__':  # Running the app
    app.run(host='127.0.0.0', port=5000, debug=True)