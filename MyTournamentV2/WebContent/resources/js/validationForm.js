//VALIDATION
    //var validationConnexion = 
$(document).ready(function(){
    $('#formLogin').bootstrapValidator({
        feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
        	emailLogin: {
                message: "Veuillez rentrer une email valide",
                validators: {
                    notEmpty: {
                        message: "Adresse email est requise"
                    },
                    stringLength: {
                        min: 6,
                        max: 35,
                        message: "L'adresse email fournie doit etre comprise entre 6 et 35 caracteres"
                    },
                    emailAddress: {
                        message: "Adresse email est invalide"
                    }
                }
            },
            passLogin: {
                validators: {
                    notEmpty: {
                        message: "Mot de pass est requis"
                    },
                    stringLength: {
                        min: 3,
                        message: "Mot de pass doit avoir minimum 3 caracteres"
                    },
                    different: {
                        field: "emailForm",
                        message: "Mot de pass doit être différent de votre adresse mail"
                    }
                }
            }
        }
    });
    
    $('#formRegister').bootstrapValidator({
        feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
        	nameRegister: {
                validators: {
                    notEmpty: {
                        message: "name est requise"
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: "name doit etre comprise entre 3 et 20 caracteres"
                    }
                }
            },
            firstnameRegister: {
                validators: {
                    notEmpty: {
                        message: "firstname est requise"
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: "firstname fournie doit etre comprise entre 6 et 35 caracteres"
                    }
                }
            },
        	emailRegister: {
        		message: "Veuillez rentrer une email valide",
                validators: {
                    notEmpty: {
                        message: "Adresse email est requise"
                    },
                    stringLength: {
                        min: 6,
                        max: 35,
                        message: "L'adresse email fournie doit etre comprise entre 6 et 35 caracteres"
                    },
                    emailAddress: {
                        message: "Adresse email est invalide"
                    }
                }
            },
            pseudoRegister: {
                validators: {
                    notEmpty: {
                        message: "Pseudo est requis"
                    },
                    stringLength: {
                        min: 3,
                        message: "Pseudo doit avoir minimum 3 caracteres"
                    }
                }
            },
            phoneRegister: {
                validators: {
                    notEmpty: {
                        message: "Phone number est requis"
                    }
                }
            },
            dobRegister: {
                validators: {
                    notEmpty: {
                        message: "date of birth est requis"
                    },
                    date: {
                        format: 'YYYY-MM-DD',
                        message: 'Date of birth is not valid'
                    }
                }
                
            },
            passRegister: {
                validators: {
                    notEmpty: {
                        message: "Mot de pass est requis"
                    },
                    stringLength: {
                        min: 3,
                        message: "Mot de pass doit avoir minimum 3 caracteres"
                    },
                    different: {
                        field: "emailRegister",
                        message: "Mot de pass doit être différent de votre adresse mail"
                    }
                }
            },
            confirmeRegister: {
                validators: {
                    notEmpty: {
                        message: "Confirme est requis"
                    },
                    stringLength: {
                        min: 3,
                        message: "Confirme doit avoir minimum 3 caracteres"
                    },
                    identical: {
                        field: 'passRegister',
                        message: 'The password and its confirm are not the same'
                    }
                }
            }
        }
    });
    $('.datepicker').on('changeDate show', function(e) {
        $('#formRegister').bootstrapValidator('revalidateField', 'dobRegister');
    });
})    

