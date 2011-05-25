<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
 
<head>
                <meta charset="utf-8">
                <title>Connection</title>
                <!-- meta -->
                <meta name="description" content="">
                <meta name="author" content="">
 
                <!-- mon icon -->
                <link rel="shortcut icon" href="Design/divers/favicon.ico">
 
                <!-- css -->
                <link rel="stylesheet" type="text/css" href="css/.css" />
                <!-- javascript -->
                <script src="javascript/plugins/jQuery_1.5.2.js" type="text/javascript"></script>
               
                <style type="text/css">
                               body{
                                               background-color: #F2F5FC;
                                               font-family: courier;
                               }
 
 
                               #oubli-mdp{
                                               margin: auto;
                                               margin-top: 9%;
                                               width: 26%;
                                               min-width: 330px;
                               }
 
 
                               form{
                                               position: absolute;
                                               width: 26%;
                                               min-width: 330px;
                               }
 
                               fieldset{
                                               padding-top: 15px;
 
                                               background: #E6EDF7;
                                               background:-moz-linear-gradient(90deg, #EEE, #E6EDF7); /* Firefox */
                                               background:-webkit-gradient(linear, left top, left bottom, from(#E6EDF7), to(#EEE)); /* Webkit */
 
                                               border: thin solid #666;
                                               border-radius: 8px;
 
                                               box-shadow: 8px 15px 3px #aaa;
                               }
 
 
                               legend{
                                               font-size: 18px;
                                               padding-bottom: 15px;
                               }
 
 
                               input[type="text"], input[type="password"], input[type="email"]{
                                               margin: 5px 0 15px 5px;
 
                                               background: -moz-linear-gradient(90deg, #FFF, #EEE);
                                               background: -webkit-gradient(linear, left top, left bottom, from(#FFF), to(#EEE)); /* Webkit */
 
                                               border: 1px solid #AAAAAA;
                                               border-radius: 4px;
                                               box-shadow: 0 0 2px #AAA;
                                               padding: 5px;
                                }
 
                               input[type="password"]{
                                               margin: 5px 0 2px 5px;
                               }
 
                               .lien{
                                               font-family: Arial;
                                               font-size: 12px;
                                               text-decoration: none;
                               }
                               .lien:hover{
                                               text-decoration: underline;
                               }
 
                               #forgetMdp{
                                               padding-left: 8px;
                               }
 
                               #spanPass:hover{
                                               text-decoration: underline;
                               }
 
                               input[type=text]:focus, input[type=password]:focus, input[type=email]:focus{
                                               box-shadow: 0 0 5px #7743F9;
                                               outline:none; /* Pour enlever le contour jaune lorsque l'on sélectionne un input dans Chrome */
                               }
 
 
                               input[type=submit]{
                                               float: right;
 
                                               margin: -2px 20px 0 0;
                                               padding: 5px 10px;
 
                                               background-color:#08ADFF;
                                               background:-moz-linear-gradient(90deg, #08ADFF, #0459B7); /* Firefox */
                                               background:-webkit-gradient(linear, left top, left bottom, from(#0459b7), to(#08ADFF)); /* Webkit */
                                               border:1px solid #093C75;
                                               border-radius:3px;
 
                                               color:#FFF;
                                               font-family: Arial
                                               font-size:13px;
                                               letter-spacing: 2px;
 
                                               cursor: pointer;
                               }
 
                               /* Balise <p> Contenant le bouton envoyer et le lien annuler */
                               #pButton{
                                               float: right;
                                               margin: 0 5px 0 0;
                               }
                               #pButton input{
                                               float: left;
                                               margin: -4px 10px 0 0;
                               }
 
 
                               /* Fonction pour Pulsate le bouton connection */
                               @-webkit-keyframes pulsate {
                                               0%          { box-shadow: 0 0 0 #0E97C9;}
                                               50% { box-shadow: 0 0 8px #0E97C9;}
                                               100%{ box-shadow: 0 0 13px #0E97C9;}
                               }
 
                               input[type=submit]:hover {
                                               -webkit-animation-name: pulsate;
                                               -webkit-animation-duration: 300ms;
                                               -webkit-animation-iteration-count: 4;
                                               -webkit-animation-direction: alternate;
 
                                               background-color:#6CCEFC;
                                               background:-moz-linear-gradient(90deg, #6CCEFC, #11B2FC); /* Firefox */
                                               background:-webkit-gradient(linear, left top, left bottom, from(#11B2FC), to(#6CCEFC)); /* Webkit */
                               }
 
                               input[type=submit]:active{
                                               background-color:#08ADFF;
                                               background:-moz-linear-gradient(90deg, #0459B7, #08ADFF); /* Firefox */
                                               background:-webkit-gradient(linear, left top, left bottom, from(#08ADFF), to(#0459b7)); /* Webkit */
                               }
 
 
                               /* Erreur Authentification */
                               #erreur-auth{
                                               opacity:0;
                                               width: 36%;
                                               min-width: 400px;
                                               margin: auto;
                                               margin-top: 3%;
                                               padding: 8px;
                                               background-color: #FCD3C9;
                                               border: 4px solid #FCAC99;
                                               border-radius: 5px;
 
                                               color: #423C3C;
                                               font-family: Arial;
                                               text-align: center;
 
                                               -moz-transition: all 1s linear;
                                               -webkit-transition: all 1s linear;
                                               transition: all 1s linear;
                               }
 
                               #erreur-auth:hover{
                                               background-color: #FCAC99;
                                               border: 4px solid #FCD3C9;
                               }
 
                               #erreur-auth img{
                                               float: left;
                                               padding-top: 3px;
 
                                               -moz-transition: all 0.6s linear;
                                               -webkit-transition: all 0.6s linear;
                                               transition: all 0.6s linear;
                               }
 
                               #erreur-auth img:hover{
                                               -moz-transform: rotate(360deg) scale(1.3, 1.3);
                                               -webkit-transform: rotate(360deg) scale(1.3, 1.3);
                               }
 
                               #erreur-auth h1{
                                               font-size: 18px;
                                               margin-top: 3px;
                               }
 
                               #erreur-auth p{
                                               margin: 2px 0 2px 0;
                                               font-size: 15px;
                               }
 
                               #erreur-auth:target{
                                               opacity: 100;
                               }
 
 
                               /* Oubli mot de passe */
                               #formForgetMdp{
                                               -moz-transition: all 0.7s ease-in-out;
                                               -webkit-transition: all 0.7s ease-in-out;
                                               z-index:5;
                                               opacity: 100;
                               }
 
                               #formCancelMdp{
                                               -moz-transition: all 0.6s ease-in-out;
                                               -webkit-transition: all 0.6s ease-in-out;
                                               transition: all 0.6s linear;
                                               opacity:0;
                               }
 
                               #oubli-mdp:target #formForgetMdp{
                                               opacity: 0;
                                               margin-left:-40%;
                                               -webkit-transform: scale(0, 0) rotate(180deg);
                               }
                               #oubli-mdp:target #formCancelMdp{
                                               opacity: 100;
                                               margin-left: 0px;
                               }
 
 
</style>
 
</head>
 
                <body>
 
 
                               <!-- Erreur d'authentification -->
                               <div id="erreur-auth">
                                               <img src="Design/divers/icone_avertissement.png" alt="icone avertissement" width="48" height="48" />
                                               <h1>Erreur authentification</h1>
                                               <p>Le nom d'utilisateur ou le mot de passe que vous avez saisi est incorrect.</p>
                               </div>
 
                               <!-- Formulaire Connexion -->
                               <div id="oubli-mdp">
                               <form id="formForgetMdp" action="./login" method="post" autocomplete="on" class="formConnect">
 
                                               <fieldset>
                                                               <legend><img id="lol" src="Design/divers/iconeLogon.png" alt="logoConnexion" width="28" height="28" /> Connexion:</legend>
 
                                                               <input type="text" name="pseudo" id="ident" required="required" placeholder="Identifiant" size="25" autofocus="autofocus" /><br />
 
                                                               <input type="password" name="mdp" id="mdp" required="required" placeholder="Mot de passe" size="25" /><br />
                                                               <a class="lien" href="#oubli-mdp">mot de passe oubli&eacute; ?</a><br />
 
                                                               <input type="submit" value="Connexion" />
 
                                               </fieldset>
                               </form>
 
                               <!-- Formulaire oublie mot de passe -->
                               <form id="formCancelMdp" action="./login" method="post" autocomplete="on" class="formForgetMdp">
 
                                               <fieldset>
                                                               <legend><img src="Design/divers/iconeMdp.png" alt="logoMotDePasse" width="28" height="28" /> Mot de passe oubli&eacute;:</legend>
 
                                                               <input type="text" name="pseudo2" id="ident2" required="required" placeholder="Identifiant" size="25" /><br />
 
                                                               <input type="email" name="email" id="email" required="required" placeholder="Adresse email" size="25" /><br />
 
                                                               <p id="pButton">
                                                                              <input type="submit" value="Envoyer" />ou <a href="#connection" class="lien">annuler</a>
                                                               </p>
 
                                               </fieldset>
                               </form>
                               </div>
 
 
                </body>
</html>