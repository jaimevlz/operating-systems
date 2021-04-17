#!/usr/bin/env bash
set -e 

. ~/.virtualenvs/python2.6/bin/activate

PYTHONPATH=. py.test --junitxml=python_tests.xml
