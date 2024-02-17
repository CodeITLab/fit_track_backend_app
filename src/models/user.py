from src.config.config import db, ma

class User(db.Model):

    __tablename__ = 'user'
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String(40), primary_key=False)
    lastName = db.Column(db.String(40), primary_key=False)
    email = db.Column(db.String(40), nullable=False)
    picture = db.Column(db.String(40), nullable=False)
    userType = db.Column(db.String(40), nullable=False)
    isAuth = db.Column(db.String(80), nullable=False)

    # method used to represent a class's objects as a string
    def __repr__(self):
        return self.name
    
class UserSchema(ma.SQLAlchemyAutoSchema):
    class Meta:
        model = User
        load_instance = True
        sqla_session = db.session

user_schema = UserSchema()
users_schema = UserSchema(many=True)