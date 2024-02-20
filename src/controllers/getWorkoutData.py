from flask import Blueprint, jsonify
from src.config.config import db
from src.models.user import Workouts, workout_schema

getWorkoutsData = Blueprint('getWorkoutsData', __name__)

@getWorkoutsData.route('/get-workouts-data')
def get_workouts_data():
    workouts = Workouts.query.all()
    # User.query.delete()
    # db.session.commit()
    return workout_schema.dump(workouts)