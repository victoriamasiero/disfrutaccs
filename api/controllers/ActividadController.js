

module.exports = {

	    registrar: function(req,res){

		Usuario.findOne(req.param('owner'), function encontraradmin (err, us) {
        if(err) {return next(err);}
        console.log(us)
        res.view({Usuario:us});// ('/Local/mostrar/'+ Local.id);

     });
	},


    create: function(req,res,next){
        
        Actividad.create(req.params.all(), function Actividadcreada (err, Actividad) {
        if(err) {return next(err);}
        console.log(Actividad)
        res.redirect ('/actividad/mostrar/'+ Actividad.id);
        

     });
    
    },

    mostrar: function(req,res,next){

    Actividad.findOne({id: req.param('id')}).exec(function(err,resultado){

    console.log(resultado)
    if (err) {return res.serverError(err);}
    console.log(resultado);
    res.view({Actividad:resultado});

         
        
     });
    }
	
};

