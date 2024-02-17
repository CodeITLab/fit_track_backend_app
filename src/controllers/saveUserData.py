from flask import Blueprint, request

saveUserData = Blueprint('saveUserData', __name__)

@saveUserData.route('/save-user-data', methods=['POST'])
def user_data():
    return request.data