import React, { Component, useState } from 'react';
import {
  View,
  Button,
  TextInput,
  StyleSheet,
  Text,
  Alert
} from 'react-native'
export default function linkAnalytics({navigation}) {
  const [textLongUrl, setLongUrl] = useState('');
  let shortl = ''





  return (
    <View style={{padding: 10}}>
      <Text>{"\n"}</Text>

      <Text>Link Analytics will be displayed here</Text>

      <Text>{"\n"}</Text>


    </View>
  );
}