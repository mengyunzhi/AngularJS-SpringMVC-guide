'use strict';

describe('Filter: yunzhiSex', function () {

    // load the filter's module
    beforeEach(module('webAppApp'));

    // initialize a new instance of the filter before each test
    var yunzhiSex;
    beforeEach(inject(function ($filter) {
        yunzhiSex = $filter('yunzhiSex');
    }));

    it('为真时，返回男', function () {
        var text = true;
        expect(yunzhiSex(text)).toBe('男');
    });

    it('为假时，返回女', function () {
        var text = false;
        expect(yunzhiSex(text)).toBe('女');
    });
});
