from flask import Blueprint, request
from src.config.config import db
from src.models.user import User, users_schema

getUserData = Blueprint('getUserData', __name__)

@getUserData.route('/get-user-data')
def get_user_data():
    userMail = request.args.get('email')
    users = User.query.filter_by(email = userMail)
    # User.query.delete()
    # db.session.commit()
    return users_schema.dump(users)