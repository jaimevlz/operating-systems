from flask import Flask
app = Flask(__name__)

@app.route("/")
def hello():
    return "ICESI 2016"

if __name__ == "__main__":
    app.run('0.0.0.0',debug=True)
