<%@ page import="java.util.ArrayList" %>
<%@ page import="com.webapp.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html class="no-js">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Programmers' Statistics App </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="fonts/font-awesome/css/font-awesome.css">
        <%--<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet"> --%>

        <script src="js/vendor/jquery-3.2.1.js" type="text/javascript"></script>

    </head>

    <body id="body">

        <div id="preloader-wrapper">
            <div class="pre-loader"></div>
        </div>

        <!--Header start
	    ==================== -->
        <div class="container">
            <nav class="navbar navigation " id="top-nav">
                <a class="navbar-brand logo" href="#">
                    <h1>Programmers' Statistics</h1>
                </a>

                <button class="navbar-toggler hidden-lg-up float-lg-right" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                  <i class="tf-ion-android-menu"></i>
              </button>
                <div class="collapse navbar-toggleable-md" id="navbarResponsive">
                    <ul class="nav navbar-nav menu float-lg-right" id="">
                        <li class="active"> <a href="#">HOME</a></li>
                        <%--<li class=""><a href=""  data-toggle="modal" data-target="#Modal"> LOGIN </a></li>--%>
                    </ul>
                </div>
            </nav>
        </div>
        <div> <button id="Shoot" type="button"> Shoot </button> <span class="badge badge-primary badge-pill" id="value"></span> </div>

        <section class="hero-area">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center">
                        <div class="col-lg-10" id="Rank">
                            <ul class="list-group">
                                 <%
                                     Constants.Lang






                                 %>
                                <li id="data20" class="list-group-item d-flex justify-content-between align-items-left"> Java <span id="data01" class="badge badge-primary badge-pill"></span></li>
                                <li id="" class="list-group-item"> Fortran </li>
                                <li id=""class="list-group-item">Python</li>
                                <li class="list-group-item">C</li>
                                <li class="list-group-item">C++</li>
                                <li class="list-group-item">C#</li>
                                <li class="list-group-item">PHP</li>
                                <li class="list-group-item">JavaScript</li>
                                <li class="list-group-item">Swift</li>
                                <li class="list-group-item">Ruby</li>
                                <li class="list-group-item">Pascal</li>
                                <li class="list-group-item">MATLAB</li>
                                <li class="list-group-item">Perl</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="block">
                            <h1 class="">Programmers' Statistics</h1>
                            <div class="input-group input-group-newsletter">
                                <p> What are You most Preferred Programming Languages?</p> <br/>
                                <div class="mb-3">
                                    <form action="" method="post">
                                        <div class="form-row">
                                            <div class="col-12 mb-3">
                                                Preferred Programming Language 1:
                                                <select id="language_one" name="language_one">
                                                    <option>Java</option>
                                                    <option>Fortran</option>
                                                    <option>Python</option>
                                                    <option>C</option>
                                                    <option>C++</option>
                                                    <option>C#</option>
                                                    <option>PHP</option>
                                                    <option>JavaScript</option>
                                                    <option>Swift</option>
                                                    <option>Ruby</option>
                                                    <option>Pascal</option>
                                                    <option>MATLAB</option>
                                                    <option>Perl</option>
                                                </select>
                                            </div>
                                            <div class="col-12 mb-3">
                                                Preferred Programming Language 2:
                                                <select name="language_two" id="language_two">
                                                    <option>Java</option>
                                                    <option>Fortran</option>
                                                    <option>Python</option>
                                                    <option>C</option>
                                                    <option>C++</option>
                                                    <option>C#</option>
                                                    <option>PHP</option>
                                                    <option>JavaScript</option>
                                                    <option>Swift</option>
                                                    <option>Ruby</option>
                                                    <option>Pascal</option>
                                                    <option>MATLAB</option>
                                                    <option>Perl</option>
                                                </select>
                                            </div>
                                            <div class="col-12 mb-3">
                                                Preferred Programming Language 3:
                                                <select name="language_three" id="language_three">
                                                    <option>Java</option>
                                                    <option>Fortran</option>
                                                    <option>Python</option>
                                                    <option>C</option>
                                                    <option>C++</option>
                                                    <option>C#</option>
                                                    <option>PHP</option>
                                                    <option>JavaScript</option>
                                                    <option>Swift</option>
                                                    <option>Ruby</option>
                                                    <option>Pascal</option>
                                                    <option>MATLAB</option>
                                                    <option>Perl</option>
                                                </select>
                                            </div>
                                        </div>
                                        <span class="input-group-btn">
                                            <button id="addYours" class="btn btn-main-sm" type="button" data-toggle="modal" data-target="#Modal">Add Yours</button>
                                        </span>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- col-md -->
                </div>
                <!-- .row close -->
            </div>
            <!-- .container close -->
        </section>
        <!-- header close -->

        <%--Modal--%>
            <div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="form">

                    <ul class="tab-group">
                        <li class="tab active"><a href="#login">Log In</a></li>
                        <li class="tab"><a href="#signup">Sign Up</a></li>

                    </ul>

                    <div class="tab-content">
                        <div id="login">
                            <form id="loginSubmit"  action="" method="post">
                                <div class="field-wrap">
                                    <label>Username<span class="req">*</span></label>
                                    <input id="username" name="username" type="text" required autocomplete="off" />
                                </div>
                                <div class="field-wrap">
                                    <label>Password<span class="req">*</span></label>
                                    <input  id="password" name="password" type="password" required autocomplete="off" />
                                </div>
                                <button  id="loginButton" type="button" class="button button-block" />Log In</button>
                            </form>
                        </div>

                        <div id="signup">
                            <form  id="signupSubmit" action="" method="post">
                                <div class="top-row">
                                    <div class="field-wrap">
                                        <label>First Name<span class="req">*</span></label>
                                        <input id="firstName" type="text" required autocomplete="off" />
                                    </div>
                                    <div class="field-wrap">
                                        <label>Last Name<span class="req">*</span></label>
                                        <input id="lastName" type="text" required autocomplete="off" />
                                    </div>
                                </div>
                                <div class="field-wrap">
                                    <label>Username<span class="req">*</span></label>
                                    <input id="usernameRegister" type="text" required autocomplete="off" />
                                </div>
                                <div class="field-wrap">
                                    <label>Set A Password<span class="req">*</span></label>
                                    <input id="passwordRegister" type="password" required autocomplete="off" />
                                </div>
                                <button id="signupButton" type="button" class="button button-block" />Get Started</button>
                            </form>
                        </div>

                    </div>
                    <!-- tab-content -->

                </div>
                <!-- /form -->
            </div>

            <%--Footer--%>
                <footer>
                    <div class="container text-center">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="block">
                                    <ul class="menu">
                                        <li class="active"><a href="#">HOME</a></li>
                                        <li class=""> <a href="" data-toggle="modal">LOG IN</a> </li>
                                    </ul>
                                    <p class="copyright-text">Copyright &copy; <a href="#">Programmers' Statistics</a>| All right reserved.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </footer>


                <!-- Js -->
                <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
                <script src="js/index.js"></script>
                <%--<script src="js/vendor/jquery-2.1.1.min.js"></script>--%>
                <script src="js/vendor/modernizr-2.6.2.min.js"></script>
                <script src="js/owl.carousel.min.js"></script>
                <script src="js/jquery.magnific-popup.min.js"></script>
                <script src="js/main.js"></script>

                <script src="js/bootstrap.min.js"></script>

    </body>

    </html>