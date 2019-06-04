/*********************************
 * Themes, rules, and i18n support
 * Locale: English
 *********************************/
(function(factory) {
    typeof module === "object" && module.exports ? module.exports = factory( require( "jquery" ) ) :
    typeof define === 'function' && define.amd ? define(['jquery'], factory) :
    factory(jQuery);
}(function($) {

    /* Global configuration
     */
    $.validator.config({
        //stopOnError: true,
        //focusCleanup: true,
        //theme: 'yellow_right',
        //timely: 2,

        // Custom rules
        rules: {
            digits: [/^\d+$/, "Veuillez remplir les chiffres seulement."]
            ,letters: [/^[a-z]+$/i, "Veuillez remplir les letters seulement."]
            ,date: [/^\d{4}-\d{2}-\d{2}$/, "Veuillez remplir une date valable, le format est : yyyy-mm-dd"]
            ,time: [/^([01]\d|2[0-3])(:[0-5]\d){1,2}$/, "Veuillez remplir le temps valide, de 00:00 et 23:59"]
            ,email: [/^[\w\+\-]+(\.[\w\+\-]+)*@[a-z\d\-]+(\.[a-z\d\-]+)*\.([a-z]{2,4})$/i, "Veuillez remplir un email valide"]
            ,url: [/^(https?|s?ftp):\/\/\S+$/i, "Veuillez remplir URL valide."]
    		,username: [/^\w{3,12}$/, "Veuillez remplir 3-12 Chiffres , Lettres ou Soulignement"]
    		,password: [/^[\S]{6,16}$/, "Remplissez de 6  à 16 caractères et ne contenez pas les espaces"]
            ,accept: function (element, params){
                if (!params) return true;
                var ext = params[0],
                    value = $(element).val();
                return (ext === '*') ||
                       (new RegExp(".(?:" + ext + ")$", "i")).test(value) ||
                       this.renderMsg("On accepte les fichiers du suffixe {1} seulement.", ext.replace(/\|/g, ', '));
            }
            
        },

        // Default error messages
        messages: {
            0: "Ce field",
            fallback: "{0} format est incorrect.",
            loading: "Validation en cours...",
            error: "Erreur de réseau.",
            timeout: "Délai de la requête dépassé.",
            required: "{0} est obligatoire.",
            remote: "Essayez un autre nom.",
            integer: {
                '*': "Veuillez entrer un nombre entier.",
                '+': "veuillez entrer un nombre entier positive.",
                '+0': "veuillez entrer un nombre entier positive or 0.",
                '-': "veuillez entrer un nombre entier negative.",
                '-0': "veuillez entrer un nombre entier negative or 0."
            },
            match: {
                eq: "{0} doit être égale à {1}.",
                neq: "{0} ne doit pas être égale à to {1}.",
                lt: "{0} doit être inférieure à {1}.",
                gt: "{0} doit être supérieure à {1}.",
                lte: "{0} doit être inférieur ou égal à {1}.",
                gte: "{0} doit être supérieur ou égal à {1}."
            },
            range: {
                rg: "Veuillez entrer un numéro entre {1} et {2}.",
                gte: "Veuillez entrer un nombre supérieur ou égal à {1}.",
                lte: "Veuillez entrer un nombre inférieur ou égal à {1}.",
                gtlt: "Veuillez inscrire le nombre de {1} à {2}.",
                gt: "Veuillez entrer un nombre supérieur à {1}.",
                lt: "Veuillez entrer un nombre inférieur à {1}."
            },
            checked: {
                eq: "Veuillez vérifier le point {1}.",
                rg: "Veuillez vérifier les points entre {1} et {2}.",
                gte: "Veuillez vérifier au moins les points {1}.",
                lte: "Veuillez ne vérifier que le point {1}."
            },
            length: {
                eq: "Veuillez entrer {1} caractères.",
                rg: "Veuillez entrer une valeur entre {1} et de {2} caractères.",
                gte: "veuillez entrer au moins {1} caractères.",
                lte: "veuillez inscrire les personnages plus {1}.",
                eq_2: "",
                rg_2: "",
                gte_2: "",
                lte_2: ""
            }
        }
    });

    /* Themes
     */
    var TPL_ARROW = '<span class="n-arrow"><b>◆</b><i>◆</i></span>';
    $.validator.setTheme({
        'simple_right': {
            formClass: 'n-simple',
            msgClass: 'n-right'
        },
        'simple_bottom': {
            formClass: 'n-simple',
            msgClass: 'n-bottom'
        },
        'yellow_top': {
            formClass: 'n-yellow',
            msgClass: 'n-top',
            msgArrow: TPL_ARROW
        },
        'yellow_right': {
            formClass: 'n-yellow',
            msgClass: 'n-right',
            msgArrow: TPL_ARROW
        },
        'yellow_right_effect': {
            formClass: 'n-yellow',
            msgClass: 'n-right',
            msgArrow: TPL_ARROW,
            msgShow: function($msgbox, type){
                var $el = $msgbox.children();
                if ($el.is(':animated')) return;
                if (type === 'error') {
                    $el.css({left: '20px', opacity: 0})
                        .delay(100).show().stop()
                        .animate({left: '-4px', opacity: 1}, 150)
                        .animate({left: '3px'}, 80)
                        .animate({left: 0}, 80);
                } else {
                    $el.css({left: 0, opacity: 1}).fadeIn(200);
                }
            },
            msgHide: function($msgbox, type){
                var $el = $msgbox.children();
                $el.stop().delay(100).show()
                    .animate({left: '20px', opacity: 0}, 300, function(){
                        $msgbox.hide();
                    });
            }
        }
    });
}));
