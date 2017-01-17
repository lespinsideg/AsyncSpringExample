var source = new EventSource('/sse/students');

source.addEventListener('message', function(e) {
    var data = JSON.parse(e.data);
    document.getElementById("content").innerHTML += "<p>" + data.name + "</p>";
}, false);

source.addEventListener('open', function(e) {
    console.log(e);
}, false);

source.addEventListener('error', function(e) {
    source.close();
}, false);