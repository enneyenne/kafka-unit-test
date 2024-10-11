import http from 'k6/http';

export let options = {
  scenarios: {
    default: {
      executor: 'constant-arrival-rate',
      duration: '5s',
      rate: 2, timeUnit: '1s',
      preAllocatedVUs: 1
    }
  }
};

export default function () {

  const url = 'http://host.docker.internal:8080/register';
  const data = {str: "testRegister"}

  http.get(url, JSON.stringify(data), {
      headers: { 'Content-Type': 'application/json' },
  });

};