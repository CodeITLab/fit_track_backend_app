from flask import Blueprint
from src.models.user import db, User

getUserData = Blueprint('getUserData', __name__)

def initDB():
    try:
        db.create_all()
        db.session.commit()
        return "Database created"
    except Exception as e:
        print(e)
        return "Database not created"    

@getUserData.route('/get-user-data')
def user_data():
    initDB()
    return "This is user data: {name: lala}"