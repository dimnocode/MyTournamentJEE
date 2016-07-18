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
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        max: 100,
                        
                    },
                    emailAddress: {
                    	
                    }
                }
            },
            passLogin: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 3,
                        max: 20
                        
                    },
                    different: {
                        field: "emailForm"
                        	
                    }
                }
            }
        }
    });
    
    $('#formUser').bootstrapValidator({
        feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
        	nameUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 3,
                        max: 20
                    }
                }
            },
            firstnameUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 3,
                        max: 20
                    }
                }
            },
        	emailUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 6,
                        max: 35
                    },
                    emailAddress: {
                    }
                }
            },
            pseudoUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 3
                    }
                }
            },
            phoneUser: {
                validators: {
                    notEmpty: {
                    	
                    }
                }
            },
            dobUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    date: {
                        format: 'YYYY-MM-DD'
                        	
                    }
                }
                
            },
            passUser: {
                validators: {
                    notEmpty: {
                        
                    },
                    stringLength: {
                        min: 3,
                        max: 20
                    },
                    different: {
                        field: "emailUser"
                    }
                }
            },
            confirmUser: {
                validators: {
                    notEmpty: {
                        
                    },
                    stringLength: {
                        min: 3, 
                        max: 20
                    },
                    identical: {
                        field: 'passUser'
                    }
                }
            }
        }
    });
    $('.datepicker').on('changeDate show', function(e) {
        $('#formUser').bootstrapValidator('revalidateField', 'dobRegister');
    });
})    

