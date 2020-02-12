import React from 'react';
import App from './App';
import {shallow} from 'enzyme';

describe('<App />', () => {

    it('will render', () => {
        // When
        const wrapper = shallow(<App/>);

        // Then
        expect(wrapper.exists()).toBeTruthy();
    });

    it('will render', () => {
        // When
        const wrapper = shallow(<App/>);

        // Then
        expect(wrapper.find('h1').text()).toBe('My React App');
    });
});