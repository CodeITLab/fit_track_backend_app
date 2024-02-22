
from flask import Blueprint, request
from src.config.config import db
from src.models.user import Workouts

saveWorkoutsData = Blueprint('saveWorkoutsData', __name__)

def initDB():
    try:
        db.create_all()
        db.session.commit()
        return "Database created"
    except Exception as e:
        print(e)
        return "Database not created" 

@saveWorkoutsData.route('/save-workouts-data', methods=['POST'])
def save_workouts_data():
    data = request.get_json()
    initDB()
    workouts = Workouts(workoutName = data['workoutName'])
    db.session.add(workouts)
    db.session.commit()
    return "save workout data", 200