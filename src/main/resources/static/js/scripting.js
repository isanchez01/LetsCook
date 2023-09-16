$(document).ready(function () {
	$("#tester").click(function (e) {
    	console.log($(window).width());
    });
    $("#aboutLetsCook").click(function (e) {
    	document.getElementById("topAbout").scrollIntoView();
    });
    $("#getAllRecipes").click(function (e) {
        document.getElementById("topAll").scrollIntoView();
    });
    $("#lookupRecipe").click(function (e) {
        document.getElementById("topGet").scrollIntoView();
    });
    $("#addRecipe").click(function (e) {
        document.getElementById("topAdd").scrollIntoView();
    });
    $("#resume").click(function (e) {
    	window.location = '/documents/Israel_Sanchez_Software_Resume.pdf';
    });
    $("#linkedin").click(function (e) {
    	window.location = 'https://www.linkedin.com/in/isanchez01/';
    });
    $("#github").click(function (e) {
    	window.location = 'https://github.com/isanchez01';
    });
});  