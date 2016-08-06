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
                    	
                    },
                    regexp: {
                    	regexp: /^[^-_()!{}$&µ£=:+;,/\.][a-zA-Z-.]+@[a-zA-Z-.]+\.[a-zA-Z]{2,10}$/
                    }
                }
            },
            passLogin: {
                validators: {
                    notEmpty: {
                    	
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
                        min: 2,
                        max: 20
                    },
                    regexp: {
                    	regexp: /^[a-z\s-]+$/i
                    }
                }
            },
            firstnameUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 2,
                        max: 20
                    },
                    regexp: {
                    	regexp: /^[a-z\s-]+$/i
                    }
                }
            },
        	emailUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 1,
                        max: 100
                    },
                    emailAddress: {
                    	
                    },
                    regexp: {
                    	regexp: /^[^-_()!{}$&µ£=:+;,/\.][a-zA-Z-.]+@[a-zA-Z-.]+\.[a-zA-Z]{2,10}$/
                    }
                }
            },
            pseudoUser: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 4,
                        max: 20
                    },
                    regexp: {
                    	regexp: /^[a-z0-9]+$/
                    }
                }
            },
            phoneUser: {
                validators: {
                    notEmpty: {
                    	
                    }
                },
                regexp:{
                	regexp: /^\d{4}///\d{3}-\d{3}$
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
                    },
                    regexp:{
                    	regexp: /^(?=.*[0-9])(?=.*[a-z])([a-zA-Z0-9]+)$/
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
    $('#formGameAccount').bootstrapValidator({
        feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
        	nameGameAccount: {
                validators: {
                    notEmpty: {
                    	
                    },
                    stringLength: {
                        min: 4,
                        max: 20
                    },
                    regexp: {
                    	regexp: /^[a-z0-9]+$/
                    }
                }
            }
        }
    });
    $('#formUserPasswordEdit').bootstrapValidator({
    	feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
        	passUserEdit: {
            	validators: {
            		notEmpty: {
                        
                    },
            		stringLength: {
                        min: 3,
                        max: 20
                    },
                    regexp:{
                    	regexp: /^(?=.*[0-9])(?=.*[a-z])([a-zA-Z0-9]+)$/
                    }
            	}
            },
        	newPassUserEdit: {
            	validators: {
            		notEmpty: {
                        
                    },
            		stringLength: {
                        min: 3,
                        max: 20
                    },
                    regexp:{
                    	regexp: /^(?=.*[0-9])(?=.*[a-z])([a-zA-Z0-9]+)$/
                    },
                    different: {
                    	field: "passUserEdit"
                    }
            	}
            },
            confirmUserEdit: {
            	validators: {
            		notEmpty: {
                        
                    },
            		stringLength: {
                        min: 3,
                        max: 20
                    },
                    identical: {
                        field: 'newPassUserEdit'
                    }
            	}
            }
        }
    });
    $('.datepicker').on('changeDate show', function(e) {
        $('#formUser').bootstrapValidator('revalidateField', 'dobRegister');
    });
})    

