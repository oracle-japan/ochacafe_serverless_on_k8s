#!/bin/bash
k6 run script/stress.js --vus 10 --duration 10s
