/**
 * Dir_actividad.js
 *
 * @description :: TODO: Tabla de union entre el id de actividad y la direccion del mismo (actulamente no en uso)
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'mysql',
  autoPK: false,
  attributes: {
    id_actividad: {
    type: 'integer'
    },
    id_direccion: {
    type: 'integer'
    }
  }
};

