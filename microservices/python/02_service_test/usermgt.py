from flask import Flask
app = Flask(__name__)

@app.route('/api/v1.0/usermgt/users',methods=['GET'])
def get_users():
	user_list = "operativos"
	return user_list

if __name__ == "__main__":
    app.run('0.0.0.0',debug=True)