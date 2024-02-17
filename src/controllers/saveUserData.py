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
    data = request.get_json()
    try:
        initDB()
        user = User(name = data['name'], lastName = data['lastName'], email = data['email'], picture = data['picture'], userType = data['userType'], isAuth = data['isAuth'])
        db.session.add(user)
        db.session.commit()
        return "user created"
    except Exception as e:
        print(e)
        return "User not created", e 
