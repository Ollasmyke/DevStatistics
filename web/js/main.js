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
            // window.location = 'index.jsp';
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
            // window.location.reload();
            alert(data);

            $.ajax({
                type: "POST",
                url: "statistics",
                success: function (data) {

                    let jsonCountLang = data[0];
                    let jsonCountLang1 = data[1];
                    let jsonCountLang2 = data[2];
                    let jsonCountLang3 = data[3];

                    $.each(jsonCountLang,function (key, values) {
                        let col1 = $("<li>").html(values).addClass("list-group-item d-flex justify-content-between align-items-left").appendTo($('#Rank'));
                        // i++; j++;
                        $("<span>").html(jsonCountLang1[key]).addClass("badge badge-primary badge-pill").appendTo(col1);
                        $("<span>").html(jsonCountLang2[key]).addClass("badge badge-primary badge-pill").appendTo(col1);
                        $("<span>").html(jsonCountLang3[key]).addClass("badge badge-primary badge-pill").appendTo(col1);

                    });

                    $('#dummy').replaceWith('#Rank');
                    $('#Modal').modal("hide");

                    // var listBadgeElement =  $('#data1');
                    // var badgeElement =  $("<span class='badge badge-primary badge-pill'></span>").text(data[0]);
                    // listBadgeElement.append(badgeElement);

                }
            });




        }
    });
});



$('#Shoot').on('click', function (e) {
    e.preventDefault();

    $.ajax({
        type: "POST",
        url: "statistics",
        success: function (data) {

            let jsonCountLang = data[0];
            let jsonCountLang1 = data[1];
            let jsonCountLang2 = data[2];
            let jsonCountLang3 = data[3];

            $.each(jsonCountLang,function (key, values) {
               let col1 = $("<li>").html(values).addClass("list-group-item d-flex justify-content-between align-items-left").appendTo($('#Rank'));
               // i++; j++;
                $("<span>").html(jsonCountLang1[key]).addClass("badge badge-primary badge-pill").appendTo(col1);
                $("<span>").html(jsonCountLang2[key]).addClass("badge badge-primary badge-pill").appendTo(col1);
                $("<span>").html(jsonCountLang3[key]).addClass("badge badge-primary badge-pill").appendTo(col1);

            });

            $('#dummy').replaceWith('#Rank');

            // var listBadgeElement =  $('#data1');
            // var badgeElement =  $("<span class='badge badge-primary badge-pill'></span>").text(data[0]);
            // listBadgeElement.append(badgeElement);

        }
    });
});