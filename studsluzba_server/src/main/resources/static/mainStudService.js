$(document).ready(function () {
var host = "http://localhost:8080";
var studentWebProfil = '';


$.get("http://localhost:8080/student/webprofile/email",{ studEmail: "mjeftic120rn@raf.rs"}, function (data, status) {   
    studentWebProfil = data;   
    $("#podaciStudent").append(studentWebProfil.aktivanIndeks.student.ime + " " 
                                + studentWebProfil.aktivanIndeks.student.prezime + " "
                                + studentWebProfil.aktivanIndeks.studProfram + "/"+studentWebProfil.aktivanIndeks.broj + "-" 
                                + studentWebProfil.aktivanIndeks.godinaUpisa);
    console.log(data);
    
});

})
