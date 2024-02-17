from flask import Blueprint
from src.config.config import db
from src.models.user import User, users_schema

getUserData = Blueprint('getUserData', __name__)

   

@getUserData.route('/get-user-data')
def get_user_data():
    users = User.query.all()
    return users_schema.dump(users)