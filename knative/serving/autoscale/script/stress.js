import http from 'k6/http';
import { check } from 'k6';
export default function () {
    const res = http.get('http://simple-serving-ocha-demo-scale.serving-demo.192.9.227.202.sslip.io/simple-greet/ocha');
    check(res, {
        'response code was 200': (res) => res.status == 200,
    });
}