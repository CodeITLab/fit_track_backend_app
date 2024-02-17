from flask import Flask

from src.controllers.getUserData import getUserData
from src.controllers.saveUserData import saveUserData
from src.config.config import db

def create_app():
    app = Flask(__name__) 
    app.config.from_object('src.config.config')  

    db.init_app(app)  
    return app

app = create_app() 

app.register_blueprint(getUserData)
app.register_blueprint(saveUserData)

if __name__ == '__main__':  # Running the app
    app.run(host='127.0.0.0', port=5000, debug=True)