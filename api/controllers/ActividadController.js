

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
        res.redirect ('/actividad/mostrar/'+ Actividad.id);
        

     });
    
    },

    mostrar: function(req,res,next){

    Actividad.findOne({id: req.param('id')}).exec(function(err,resultado){

    if (err) {return res.serverError(err);}

    Resena.find({idactividad:resultado.id}).exec(function(err,resultadoresena){
            console.log(resultadoresena);

            if(resultadoresena === undefined){
            return res.view({Actividad:resultado}); }
            
            else{

                resultado.Resena = resultadoresena;
                res.view({Actividad:resultado});}

              
         });
        
     });
    },

    buscar: function(req,res,next){

    Actividad.find({Nombre:{'contains':req.param('Nombre')} }).exec(function(err,resultado){
    
    if (err) {return res.serverError(err);}

    if(resultado !== undefined) {
    console.log(resultado);
    res.view({Actividad:resultado});
    }
    if(resultado === undefined){
    return res.notFound('Could not find, sorry.');}

     });    
    } ,

    consultar: function(req,res){
     res.view();
    },

    misactividades: function(req,res,next){
        var id = req.param('id');
        console.log(id);
        if(id !== undefined){ Actividad.find({owner:id}).exec(function(err,resultado){
    
         if (err) {return res.serverError(err);}

         if(resultado !== undefined) {
             console.log(resultado);
             res.view({Actividad:resultado});
         }
         if(resultado === undefined){return res.notFound('No hay locales con ese nombre :c ');}

            });  
        };

    }

	
};

