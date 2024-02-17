from flask import Blueprint

getUserData = Blueprint('getUserData', __name__)

@getUserData.route('/get-user-data')
def user_data():
    return "This is user data: {name: lala}"