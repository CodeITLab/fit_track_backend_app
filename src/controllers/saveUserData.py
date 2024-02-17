from flask import Blueprint, request, jsonify
from src.config.config import db
from src.models.user import User

saveUserData = Blueprint('saveUserData', __name__)

def initDB():
    try:
        db.create_all()
        db.session.commit()
        return "Database created"
    except Exception as e:
        print(e)
        return "Database not created" 

@saveUserData.route('/save-user-data', methods=['POST'])
def user_data():
    initDB()
    user = User(name = 'sasa', lastName = 'Zelen', email = 'lalala', picture = 'll', userType = 'Personal', isAuth = 'hoho')
    db.session.add(user)
    db.session.commit()
    return "user created"