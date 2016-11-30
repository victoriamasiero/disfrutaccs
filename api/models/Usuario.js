/**
 * Usuario.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'PostgresqlServer',
  attributes: {
    
    Nombre: {
      type: 'string',
      size: 45,
      notNull: true,
      required: true
    },
    Apellido: {
      type: 'string',
      size: 45,
      notNull: true
    },
    Fecha_de_nacimiento: {
      type: 'date',
      notNull:true
    },
    Edad: {
      type: 'integer',
    },
    Indentificador: {
      type: 'boolean'
    },
    Correo: {
      type: 'email',
      email:true,
      unique: true,
      notNull:true
    },
    Alias: {
      type: 'string',
      size:45,
      unique: true
    },
      Clave: {
      type: 'string',
      size:20,
      required: true
    },
     preferencias: {
      collection:'Natural',
      via: 'idusuario'
    },
    pets: {
      collection: 'Actividad',
      via: 'owner'
    },
    Resena: {
      collection: 'Resena',
      via: 'idusuario'
    }
  } 
};
