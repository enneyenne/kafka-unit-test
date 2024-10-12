import http from 'k6/http';

export let options = {
  scenarios: {
    default: {
      executor: 'constant-arrival-rate',
      rate: 1,
      timeUnit: '1s',
      duration: '1m',
      preAllocatedVUs: 1,
    }
  }
};

export default function () {

  const urlRegister = 'http://host.docker.internal:8080/register';
  const urlOnline = 'http://host.docker.internal:8080/online';

  const dataRegister = {str: "testRegister"};
  const dataOnline = {str: "testOnline"};

  http.post(urlRegister, JSON.stringify(dataRegister), {
      headers: { 'Content-Type': 'application/json' },
  });

  http.post(urlOnline, JSON.stringify(dataOnline), {
      headers: { 'Content-Type': 'application/json' },
  });

};