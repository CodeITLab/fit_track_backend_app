from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()

class User(db.Model):
    '''Data for ON/OFF should be dumped in this table.'''

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
        return '<machineid %r>' % self.name