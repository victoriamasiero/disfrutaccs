/**
 * Dir_actividad.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'PostgresqlServer',
  attributes: {
    id_e: {
    type: 'integer'
    },
    id_a: {
    type: 'integer'
    }
  }
};

