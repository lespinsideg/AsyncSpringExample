var xhr = new XMLHttpRequest();
xhr.onload = function(e) {
    var data = e.target.response;
    data.forEach(function(student, _) {
        document.getElementById('content').innerHTML += '<p>' + student.name + '</p>';
    });
}

xhr.open('GET', '/students', true);
xhr.responseType = 'json';
xhr.send();