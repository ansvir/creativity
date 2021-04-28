$(document).ready(function() {
    let menuToggle = $("#menu-toggle");
    menuToggle.click(function (e) {
        e.preventDefault();
        let wrapper = $("#wrapper");
        if (wrapper.hasClass("toggled")) {
            menuToggle.text("Hide menu");
        } else {
            menuToggle.text("Show menu");
        }
        wrapper.toggleClass("toggled");
    });

    // $("#nameGenerationTab").hover(function() {
    //     $("#nameGenerationTab").mouseenter(function(){
    //         $("#nameGenerationDropDown").show();
    //     });
    //
    //     $("#nameGenerationDropDown, #nameGenerationTab").mouseleave(function(){
    //         $("#nameGenerationDropDown").hide();
    //     });
    // });
    //
    // $("#languageEditorTab").hover(function() {
    //     $("#languageEditorTab").mouseenter(function(){
    //         $("#languageEditorDropDown").show();
    //     });
    //
    //     $("#languageEditorDropDown, #languageEditorTab").mouseleave(function(){
    //         $("#languageEditorDropDown").hide();
    //     });
    // });
});