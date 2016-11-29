/**
 * Dir_actividad.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'mysql',
  autoPK: false,
  attributes: {
    id_aactividad: {
    type: 'integer'
    },
    id_direccion: {
    type: 'integer'
    }
  }
};

