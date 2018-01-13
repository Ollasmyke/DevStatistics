$(window).load(function() {
    $("#preloader-wrapper").fadeOut("slow");
});

$(document).ready(function(){

    //animated header class
    $(window).scroll(function() {
        var scroll = $(window).scrollTop();
        //console.log(scroll);
        if (scroll > 200) {
            //console.log('a');
            $(".navigation").addClass("animated");
        } else {
            //console.log('a');
            $(".navigation").removeClass("animated");
        }});

    $(".gallery-slider").owlCarousel(
        {
            pagination : true,
            autoPlay : 5000,
            itemsDesktop  :  [1500,4],
            itemsDesktopSmall :  [979,3]
        }
    );

    // Gallery Popup
    $('.image-popup').magnificPopup({type:'image'});

});

// ================================ Custom JS! ===========================================

var Language = [];

$('#addYours').click(function () {
    Language.one = $('#language_one').val();
    Language.two = $('#language_two').val();
    Language.three = $('#language_three').val();

})


$('#loginButton').on('click', function (e) {
    e.preventDefault();

    var username = $("#username").val();
    var password = $("#password").val();

    // alert (password);
    $.ajax({
        type: "POST",
        url: "response",
        data: {username: username, password: password, one: Language.one, two: Language.two, three: Language.three},
        success: function (data) {
            window.location = 'index.jsp';
            alert(data);

        }
    });
});
//
// $('#addYours').click(function () {
//     Language.one = $('#language_one').val();
//     Language.two = $('#language_two').val();
//
// })

$('#signupButton').on('click', function (e) {
    e.preventDefault();

    var firstName = $("#firstName").val();
    var lastName = $("#lastName").val();
    var username = $("#usernameRegister").val();
    var password = $("#passwordRegister").val();


    $.ajax({
        type: "POST",
        url: "register",
        data: {firstName: firstName, lastName: lastName, username: username, password: password, one: Language.one, two: Language.two, three: Language.three},
        success: function (data) {
            window.location.reload();
            alert(data);

        }
    });
});

$('#Shoot').on('click', function (e) {
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "statistics",
        success: function (data) {


            

            let listElement =  $('#data20');
            let badgeElement =  $("<span class='badge badge-primary badge-pill'></span>").text(data[1]);
            listElement.append(badgeElement);




        }
    });
});